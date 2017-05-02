package twoexam.contactlist.controllers;

import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import twoexam.contactlist.dto.Contactlist;
import twoexam.contactlist.service.IContactlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

    @Controller
    public class ContactlistController extends BaseController{

    @Autowired
    private IContactlistService service;


    @RequestMapping(value = "/contactlist/query")
    @ResponseBody
    public ResponseData query(Contactlist dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/contactlist/submit")
    @ResponseBody
    public ResponseData update(HttpServletRequest request,@RequestBody List<Contactlist> dto){
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/contactlist/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<Contactlist> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }
    }