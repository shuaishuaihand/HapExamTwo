package hap.fruit.controllers;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hand.hap.account.dto.Role;
import com.hand.hap.adaptor.ILoginAdaptor;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.excel.dto.ColumnInfo;
import com.hand.hap.excel.dto.ExportConfig;
import com.hand.hap.excel.service.IExportService;
import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import hap.fruit.dto.Fruit;
import hap.fruit.service.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

@Controller
    public class FruitController extends BaseController{

    @Autowired
    private IFruitService service;
    @Autowired(
            required = false
    )
    private ILoginAdaptor loginAdaptor;
    private IExportService excelService;
    private ObjectMapper objectMapper;

    public ILoginAdaptor getLoginAdaptor() {
        return loginAdaptor;
    }

    @RequestMapping(value = "/fruit/query")
    @ResponseBody
    public ResponseData query(Fruit dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/fruit/submit")
    @ResponseBody
    public ResponseData submit(@RequestBody List<Fruit> fruits, BindingResult result, HttpServletRequest request) throws BaseException {
        this.getValidator().validate(fruits, result);
        if(result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(this.getErrorMessage(result, request));
            return rd;
        } else {
            IRequest requestContext = this.createRequestContext(request);
            return new ResponseData(this.service.batchUpdate(requestContext, fruits));
        }
    }

    @RequestMapping(value = "/fruit/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<Fruit> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }

    @RequestMapping({"/fruit/export"})
    public void createXLS(HttpServletRequest request, @RequestParam String config, HttpServletResponse httpServletResponse) {
        IRequest requestContext = this.createRequestContext(request);

        try {
            JavaType type = this.objectMapper.getTypeFactory().constructParametrizedType(ExportConfig.class, ExportConfig.class, new Class[]{hap.fruit.dto.Fruit.class, ColumnInfo.class});
            ExportConfig<hap.fruit.dto.Fruit, ColumnInfo> exportConfig = (ExportConfig)this.objectMapper.readValue(config, type);
            this.excelService.exportAndDownloadExcel("com.hand.hap.function.mapper.FunctionMapper.selectFunctions", exportConfig, request, httpServletResponse, requestContext);
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }

    @RequestMapping(
            value = {"/elogin.html", "/elogin"},
            method = {RequestMethod.GET}
    )
    public ModelAndView roleView(HttpServletRequest request, HttpServletResponse response) throws BaseException {
        ModelAndView mv = new ModelAndView("fruit/elogin.html");
        return mv;
    }


}