package hap.fruit.mapper;

import com.hand.hap.mybatis.common.Mapper;
import hap.fruit.dto.Fruit;

import java.util.List;

public interface FruitMapper extends Mapper<Fruit>{
    int myUpdate(Fruit fruit);
   /* List<Fruit> selectFruit(Fruit var1);*/
}