package quantrivanphong.report.issuescomment.bussiness;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quantrivanphong.common.HttpStatus.WrapperResult;
import quantrivanphong.models.IssuesCommentModels;
import quantrivanphong.report.issues.repository.IssueRepository;
import quantrivanphong.dto.IssuesCommentDTO;
import quantrivanphong.report.issuescomment.repository.IssuesCommentRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class IssuesCommentBussinessImpl implements IssuesCommentBussiness{
    Logger logger = Logger.getLogger(IssuesCommentBussinessImpl.class);
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private IssuesCommentRepository issuesCommentRepository;
    @Override
    public List<IssuesCommentDTO> getListComment(Integer issuesId) {
        return lstDTO(issuesCommentRepository.findIssuesCommentByIssuesId(issuesId));
    }

    @Override
    public WrapperResult createComment(IssuesCommentDTO dto) {
        String views ="";
        int status = 113;
        dto.setUserCreate("phungdung");
        if(dto.getUserCreate()!=null){
            try{
            dto.setCreateDate(new Timestamp(System.currentTimeMillis()));
            IssuesCommentModels issuesComment = issuesCommentRepository.save(Models(dto));
                views="tạo comment thành công!";
            status = 200;
            }catch (Exception e){
                logger.info(" Lỗi Insert Comment "+e.getMessage());
                views="Lỗi Tạo Comment";
            }
        }else{
            views="Vui lòng đăng nhập để thực hiện chức năng này";
        }
        return new WrapperResult(status,views);
    }

    @Override
    public WrapperResult updateComment(IssuesCommentDTO dto) {
        return null;
    }

    @Override
    public WrapperResult deleteComment(IssuesCommentDTO dto) {
        return null;
    }

    @Override
    public IssuesCommentDTO findIssuesCommentById(Integer id) {
        return DTO(issuesCommentRepository.findIssuesCommentById(id));
    }
    public IssuesCommentModels Models(IssuesCommentDTO dto){
        IssuesCommentModels issuesComment = new IssuesCommentModels();
        BeanUtils.copyProperties(dto,issuesComment);
        if(dto.getIssueId()!=null){
        issuesComment.setIssues(issueRepository.findIssuesById(dto.getIssueId()));
        }
        return issuesComment;
    }
    public IssuesCommentDTO DTO(IssuesCommentModels issuesComment){
        IssuesCommentDTO dto = new IssuesCommentDTO();
        BeanUtils.copyProperties(issuesComment,dto);
        return dto;
    }
    public List<IssuesCommentDTO> lstDTO(List<IssuesCommentModels> lst){
        List<IssuesCommentDTO> lstDTO = new ArrayList<IssuesCommentDTO>();
        for (IssuesCommentModels issuesComment:lst) {
            lstDTO.add(DTO(issuesComment));
        }
        return lstDTO;
    }
}
