package hap.fruit.service.impl;

import com.github.pagehelper.PageHelper;
import com.hand.hap.cache.impl.HashStringRedisCacheGroup;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hap.fruit.mapper.FruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import hap.fruit.dto.Fruit;
import hap.fruit.service.IFruitService;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FruitServiceImpl extends BaseServiceImpl<Fruit> implements IFruitService{
    @Autowired
    private FruitMapper fruitMapper;
  /*  @Autowired
    @Qualifier("fruitCache")
    private HashStringRedisCacheGroup<Fruit> fruitCache;*/


    @Override
    public int updateList(List<Fruit> fruitList) {
        fruitList.forEach(fruit -> checkOvn(fruitMapper.myUpdate(fruit),fruit));
        return fruitList.size();
    }

    /*@Override
    public List<Fruit> selectFruit(IRequest var1, Fruit var2, int var3, int var4) {
        return null;
    }*/

    /*@Override
    public List<Fruit> selectFruit(IRequest request, Fruit example, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Fruit> list = this.fruitMapper.selectFruit(example);
        List<Fruit> allFruits = this.fruitCache.getGroup(request.getLocale()).getAll();
        Map<Long, Fruit> idFruMap = new HashMap();
        allFruits.forEach((f) -> {
            Fruit var10000 = (Fruit) idFruMap.put(f.getId(), f);
        });
        return list;
    }*/

}