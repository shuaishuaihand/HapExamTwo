package twoexam.contactlist.service.impl;

import com.hand.hap.system.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import twoexam.contactlist.dto.Contactlist;
import twoexam.contactlist.service.IContactlistService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactlistServiceImpl extends BaseServiceImpl<Contactlist> implements IContactlistService{

}