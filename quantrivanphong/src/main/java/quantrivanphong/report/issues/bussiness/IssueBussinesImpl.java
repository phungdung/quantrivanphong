package quantrivanphong.report.issues.bussiness;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.manager.project.repository.ProjectRepository;
import quantrivanphong.models.IssuesModels;
import quantrivanphong.dto.IssueDTO;
import quantrivanphong.report.issues.repository.IssueRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class IssueBussinesImpl implements IssueBussiness {

    Logger logger = Logger.getLogger(IssueBussinesImpl.class);

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<IssuesModels> getAllIssue() {
        return issueRepository.findAll();
    }

    @Override
    public WrapperResult saveIssue(IssueDTO issueDTO) {
        String views = null;
        int status = 113;
        try {

            issueDTO.setStatus(0);
            issueDTO.setStartDate(new Timestamp(System.currentTimeMillis()));
            IssuesModels saveIssues = issueRepository.save(dtoParseModels(issueDTO));
            if (saveIssues != null) {
                views = "thêm thành công Issues !";
                status = 200;
            } else {
                views = "thêm Issues không thành công!";
            }
        } catch (Exception e) {
            logger.info("Lỗi insert " + e.getMessage());
            views = "Lỗi thêm dữ liệu";
        }
        return new WrapperResult(status, views);
    }

    @Override
    public WrapperResult updateIssue(IssueDTO issueDTO) {
        String views = null;
        int status = 113;
        try {
            IssuesModels issues = issueRepository.findIssuesById(issueDTO.getId());
            if (issues != null) {
                if (issues.getStatus() == 0) {
                    issues.setStatus(1);
                }else{
                    issues.setStatus(0);
                }
                IssuesModels saveIssues = issueRepository.save(issues);
                if (saveIssues != null) {
                    views = "Cập nhật thành công Issues !";
                    status = 200;
                } else {
                    views = "không thành công!";
                }
            } else {
                views = "Issue không tồn tại!";
            }
        } catch (Exception e) {
            logger.info("Lỗi Cập nhật " + e.getMessage());
            views = "Lỗi Cập nhật dữ liệu";
        }
        return new WrapperResult(status, views);
    }

    @Override
    public WrapperResult deleteIssue(IssueDTO issueDTO) {
        String views = null;
        int status = 113;
        try {
            IssuesModels issues = issueRepository.findIssuesById(issueDTO.getId());
            if (issues != null) {
                issueRepository.deleteById(issueDTO.getId());
                views = "Xóa thành công Issues !";
                status = 200;
            } else {
                views = "Issue không tồn tại!";
            }
        } catch (Exception e) {
            logger.info("Lỗi Delete " + e.getMessage());
            views = "Lỗi xóa dữ liệu";
        }
        return new WrapperResult(status, views);
    }

    @Override
    public IssuesModels findIssueById(Integer id) {
        return issueRepository.findIssuesById(id);
    }

    public IssueDTO modelsParseDTO(IssuesModels models) {
        IssueDTO issueDTO = new IssueDTO();
        BeanUtils.copyProperties(models, issueDTO);
        return issueDTO;
    }

    public IssuesModels dtoParseModels(IssueDTO dto) {
        IssuesModels issues = new IssuesModels();
        BeanUtils.copyProperties(dto, issues);
        issues.setProject(projectRepository.findProjectById(dto.getProjectId()));
        return issues;
    }

    public List<IssueDTO> lstModel(List<IssuesModels> lstModel) {
        if (lstModel.size() != 0 && !lstModel.isEmpty()) {
            List<IssueDTO> lstDTO = new ArrayList<IssueDTO>();
            for (IssuesModels issues : lstModel) {
                lstDTO.add(modelsParseDTO(issues));
            }
            return lstDTO;
        }
        return null;
    }
}
