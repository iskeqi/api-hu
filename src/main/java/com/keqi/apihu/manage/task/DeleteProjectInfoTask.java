package com.keqi.apihu.manage.task;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 定时任务删除项目中的数据（根据实际使用情况来判断是否开启吧）
 */
@Component
@Slf4j
@AllArgsConstructor
public class DeleteProjectInfoTask {

    /*private final ProjectMapper projectMapper;
    private final ProjectService projectService;*/

    // 根据 cron 表达式定义，每月 15 日 10:15 分运行。
    /*@Scheduled(cron = "0 15 10 15 * ?")
    public void scheduleWithCronExpression() throws Exception {
        List<ProjectDO> projects = this.projectMapper.findAllDisableProjects();
        if (projects.size() > 0) {
            for (ProjectDO project : projects) {
                log.info("删除项目 {} 所有数据任务开启", project.getProjectName());

                // 此操作过于危险，还是不要做了(以后再决定到底要不要删除，或者删除前导出当前项目的所有信息)
                // this.projectService.deleteProjectAllInfoById(project.getId());

                log.info("删除项目 {} 所有数据任务开启", project.getProjectName());
            }
        }
    }*/
}
