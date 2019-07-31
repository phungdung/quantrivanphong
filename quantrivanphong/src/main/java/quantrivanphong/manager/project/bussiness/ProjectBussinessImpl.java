package quantrivanphong.manager.project.bussiness;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import quantrivanphong.common.Page.AbstractDaoPage;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.dto.ProjectDTO;
import quantrivanphong.manager.project.repository.ProjectRepository;
import quantrivanphong.models.ProjectModels;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectBussinessImpl implements ProjectBussiness {
    private Logger logger = Logger.getLogger(ProjectBussinessImpl.class);
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectDTO> findAllProject() {
        try {
            return lstDTO(projectRepository.findAll());
        } catch (Exception e) {
            logger.info("Lỗi findAll " + e.getMessage());
        }
        return null;
    }

    @Override
    public WrapperResult updateProject(ProjectDTO dto) {
        String views = null;
        int status = 113;
        try {
            ProjectDTO projectDTO = findByProjectId(dto.getId());
            dto.setStartDate(projectDTO.getStartDate());
            dto.setEndDate(projectDTO.getEndDate());
            if (dto.getStartDate() == null) {
                views = "ngày bắt đầu dự án không được null";
            } else if (dto.getEndDate() == null) {
                views = "ngày dự kiếm kết thúc dự án không được null";
            } else if (projectDTO != null) {
                ProjectDTO updateProject = modelparseDto(projectRepository.save(dtoParseModels(dto)));
                if (updateProject != null) {
                    views = "sửa thành công project";
                    status = 200;
                }
            } else {
                views = "không tìm thấy project phù hợp";
            }
        } catch (Exception e) {
            logger.info("Lỗi update" + e.getMessage());
            views = "lỗi update project";
        }
        return new WrapperResult(status, views);
    }

    @Override
    public WrapperResult saveProject(ProjectDTO dto) {
        String views = null;
        int status = 113;
        if (projectRepository.findByName(dto.getName()) == null) {
            try {
                if (dto.getStartDate() == null) {
                    views = "ngày bắt đầu dự án không được null";
                } else if (dto.getEndDate() == null) {
                    views = "ngày dự kiếm kết thúc dự án không được null";
                } else {
                    dto.setStatus(0);
//                projectRepository.saveEntity(dtoParseModels(dto));
                    ProjectDTO saveProject = modelparseDto(projectRepository.save(dtoParseModels(dto)));
                    if (saveProject != null) {
                        views = "thêm thành công project !";
                        status = 200;
                    } else {
                        views = "thêm project không thành công!";
                    }
                }
            } catch (Exception e) {
                logger.info("Lỗi insert " + e.getMessage());
                views = "Lỗi thêm dữ liệu";
            }
        } else {
            views = "Đã tồn tại Dự Án";
        }
        return new WrapperResult(status, views);
    }

    @Override
    public ProjectDTO findByProjectId(Integer id) {
        try {
            ProjectDTO projectDTO = modelparseDto(projectRepository.findProjectById(id));
            if (projectDTO != null) {
                return projectDTO;
            }
        } catch (Exception e) {
            logger.info("( Lỗi tìm kiếm ) " + e.getMessage());
        }
        return null;
    }

    @Override
    public WrapperResult deleteProjectById(Integer id) {
        String views = null;
        int status = 113;
        logger.info("deleteProjectById");
        if (findByProjectId(id) != null) {
            try {
                projectRepository.deleteById(id);
                views = "xóa thành công project";
                status = 200;
            } catch (Exception e) {
                logger.info("lỗi :" + e.getMessage());
                views = "Lỗi xóa";
            }
        } else {
            views = "dự án không tồn tại không tồn tại";
        }
        return new WrapperResult(status, views);
    }

    @Override
    public AbstractDaoPage<ProjectDTO> getPageProject(int page, int pageSize) {
        AbstractDaoPage<ProjectDTO> abstractDaoPage = new AbstractDaoPage<ProjectDTO>();
        List<ProjectModels> lstM = getListPage(page,pageSize);
        List<ProjectDTO> listDTO = lstDTO(lstM);
        abstractDaoPage.setLstResult(listDTO);
        abstractDaoPage.setPage(page);
        abstractDaoPage.setMaxPageItem(pageSize);
        abstractDaoPage.setTotalItem(findAllProject().size());
        abstractDaoPage.setTotalPage((int)Math.ceil((double) abstractDaoPage.getTotalItem()/abstractDaoPage.getMaxPageItem()));
        return abstractDaoPage;
    }

    public List<ProjectModels> getListPage(int page, int pageSize) {
        Pageable paging = PageRequest.of(page,pageSize);
        Page<ProjectModels> pagedResult = projectRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<ProjectModels>();
        }
    }

    public List<ProjectDTO> lstDTO(List<ProjectModels> lstModels) {
        List<ProjectDTO> lstDTO = new ArrayList<>();
        for (ProjectModels project : lstModels) {
            lstDTO.add(modelparseDto(project));
        }
        return lstDTO;
    }

    public ProjectDTO modelparseDto(ProjectModels model) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescriptions(model.getDescriptions());
        dto.setStartDate(model.getStartDate());
        dto.setEndDate(model.getEndDate());
        dto.setStatus(model.getStatus());

        return dto;
    }

    public ProjectModels dtoParseModels(ProjectDTO projectDTO) {
        ProjectModels project = new ProjectModels();
        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setDescriptions(projectDTO.getDescriptions());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        project.setStatus(projectDTO.getStatus());
        return project;
    }
}
