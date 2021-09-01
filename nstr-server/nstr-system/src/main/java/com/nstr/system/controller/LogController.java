package com.nstr.system.controller;

import com.nstr.common.core.constant.StringConstant;
import com.nstr.common.core.entity.QueryRequest;
import com.nstr.common.core.entity.system.Log;
import com.nstr.common.core.utils.NstrResponse;
import com.nstr.common.core.utils.NstrUtils;
import com.nstr.system.annotation.ControllerEndpoint;
import com.nstr.system.service.ILogService;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * @author: cactusli
 * @date: 2021.08.16
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("log")
public class LogController {

    private final ILogService logService;

    @GetMapping
    public NstrResponse logList(Log log, QueryRequest request) {
        Map<String, Object> dataTable = NstrUtils.getDataTable(this.logService.findLogs(log, request));
        return new NstrResponse().data(dataTable);
    }

    @DeleteMapping("{ids}")
    @PreAuthorize("hasAuthority('log:delete')")
    @ControllerEndpoint(exceptionMessage = "删除日志失败")
    public void deleteLogss(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] logIds = ids.split(StringConstant.COMMA);
        this.logService.deleteLogs(logIds);
    }

    @PostMapping("excel")
    @PreAuthorize("hasAuthority('log:export')")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest request, Log lg, HttpServletResponse response) {
        List<Log> logs = this.logService.findLogs(lg, request).getRecords();
        ExcelKit.$Export(Log.class, response).downXlsx(logs, false);
    }
}
