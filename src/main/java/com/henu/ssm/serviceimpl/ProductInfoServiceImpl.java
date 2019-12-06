package com.henu.ssm.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.henu.ssm.bean.ProductCategory;
import com.henu.ssm.bean.ProductInfo;
import com.henu.ssm.bean.ProductInfoExample;
import com.henu.ssm.dao.ProductInfoMapper;
import com.henu.ssm.dto.CategoryDTO;
import com.henu.ssm.dto.ProductDTO;
import com.henu.ssm.model.ProductModel;
import com.henu.ssm.service.ProductCategoryService;
import com.henu.ssm.service.ProductInfoService;
import com.henu.ssm.util.UUIDutil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author shkstart
 * @create 2019-09-23 15:35
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    //注入类目业务层对象
    @Autowired
    public ProductCategoryService CategoryService;

    //注入商品dao层对象
    @Autowired
    public ProductInfoMapper productInfoMapper;
    public List<CategoryDTO> selectProducts() {
        //类目及其商品集合
        List<CategoryDTO> categoryDTOList=new ArrayList<CategoryDTO>();
        //查所有类目
        List<ProductCategory> productCategories =
                CategoryService.selectCategories();
        //获取类目type，根据type查询所属商品
        //遍历类目
        for(ProductCategory pc:productCategories){
            //封装CategoryDTO
            CategoryDTO categoryDTO=new CategoryDTO();
            categoryDTO.setName(pc.getCategoryName());
            categoryDTO.setType(pc.getCategoryType());
            //获取类目编码
            int type= pc.getCategoryType();
            //根据type查询商品
            ProductInfoExample productInfoExample=new ProductInfoExample();
            ProductInfoExample.Criteria criteria = productInfoExample.createCriteria();
            criteria.andCategoryTypeEqualTo(type);
            //商品查询
            List<ProductInfo> productInfos = productInfoMapper.selectByExample(productInfoExample);
            //用于封装ProducntDTO集合
            List<ProductDTO> productDTOList= new ArrayList<ProductDTO>();;
            //遍历商品并转换成ProductDTO
            for (ProductInfo productInfo : productInfos) {
                ProductDTO  productDTO=new ProductDTO();
                productDTO.setDescription(productInfo.getProductDescription());
                productDTO.setIcon(productInfo.getProductIcon());
                productDTO.setId(productInfo.getProductId());
                productDTO.setName(productInfo.getProductName());
                int i = productInfo.getProductPrice().intValue();
                productDTO.setPrice(Double.valueOf(i));
                //把当前类下的商品封装到一个list对象中
                productDTOList.add(productDTO);
            }
            //把商品类目与所属商品关联
            categoryDTO.setFoods(productDTOList);
            //把封装CategoryDTO封装到list中
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }


    @Override
    public Map<String, Object> selectProductInfo(ProductInfoExample example, Integer pageNum, Integer pageSize) {
        //设置分页信息
        PageHelper.startPage(pageNum, pageSize);
        //设置排序id排序
        example.setOrderByClause("product_id asc");
        //执行查询
        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        List<ProductModel> list2 = new ArrayList<>();
        for (ProductInfo productInfo : list) {
            ProductModel productModel = new ProductModel();
            BeanUtils.copyProperties(productInfo,productModel);
            if(productInfo.getProductStatus()==0){
                productModel.setProductStatus("上架");
                list2.add(productModel);
            }else{
                productModel.setProductStatus("下架");
                list2.add(productModel);
            }
        }
        //获取分页信息
        PageInfo<ProductInfo> pageInfo= new PageInfo<>(list);
        Map<String, Object> map = new HashMap<>();
        //获取总记录数
        map.put("total", pageInfo.getTotal());
        map.put("rows", list2);
        return map;
    }

    //根据id删除
    @Override
    public int deleteByPrimaryKey(String productId) {
        return productInfoMapper.deleteByPrimaryKey(productId);
    }

    //条件更新操作
    @Override
    public int updateByPrimaryKeySelective(ProductInfo productInfo) {
        return productInfoMapper.updateByPrimaryKeySelective(productInfo);
    }

    //添加操作
    @Override
    public int insert(ProductInfo productInfo) {
        productInfo.setProductId(UUIDutil.getUUID());
        productInfo.setCreateTime(new Date());
        productInfo.setUpdateTime(new Date());
        productInfo.setProductStatus(1);
        return productInfoMapper.insert(productInfo);
    }

    //根据id查询
    @Override
    public ProductInfo selectByPrimaryKey(String productId) {
        return productInfoMapper.selectByPrimaryKey(productId);
    }

}

