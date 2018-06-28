package com.shigu.main4.order.process;

import com.shigu.main4.order.exceptions.CartException;
import com.shigu.main4.order.model.Cart;
import com.shigu.main4.order.vo.CartVO;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品进货车对外服务
 * Created by bugzy on 2017/8/12 0012.
 */
@Component("itemCartProcess")
public class ItemCartProcessImpl implements ItemCartProcess {

    /**
     * 获取用户购物车内所有产品
     * @param userId 所属用户
     * @return 产品列表
     */
    @Override
    public List<CartVO> someOneCart(Long userId) {
        return SpringBeanFactory.getBean(Cart.class, userId).listProduct();
    }

    /**
     * 根据用户id 子订单Id 查询子订单
     * @param userId
     * @param childCartIds
     * @return
     */
    @Override
    public List<CartVO> selByChildCartIds(Long userId,String childCartIds){
        return SpringBeanFactory.getBean(Cart.class, userId).listSomeProduct(childCartIds);
    };

    /**
     * 某用户购物车商品数量
     * @param userId 所属用户
     * @return 商品合计总件数
     */
    @Override
    public int productNumbers(Long userId) {
        return SpringBeanFactory.getBean(Cart.class, userId).productNumbers();
    }

    /**
     * 修改进货车商品数量
     * @param userId 用户
     * @param cid 商品属性
     * @param number 件数
     */
    @Override
    public void modProductNumber(Long userId, Long cid, Integer number) throws CartException {
        SpringBeanFactory.getBean(Cart.class, userId).modifyProductNumber(cid, number);
    }

    /**
     * 删除进货车商品
     *
     * @param userId 用户
     * @param cid    商品
     */
    @Override
    public void rmProduct(Long userId, Long cid) {
        SpringBeanFactory.getBean(Cart.class, userId).rmProduct(cid);
    }

    /**
     * 修改进货车商品属性
     *
     * @param userId 用户
     * @param cid    商品
     * @param color  颜色
     * @param size   尺码
     */
    @Override
    public void modifyProductSku(Long userId, Long cid, String color, String size) throws CartException {
        SpringBeanFactory.getBean(Cart.class, userId).modifyProductSku(cid, color, size);
    }

    /**
     * 向进货车添加商品
     *
     * @param userId 用户
     * @param vo     商品信息
     * @param count  数量
     */
    @Override
    public void addProduct(Long userId, ItemProductVO vo, Integer count) {
        if (count<=0) {
            return;
        }
        SpringBeanFactory.getBean(Cart.class, userId).addProduct(vo, count);
    }

    /**
     * 清除某用户进货车中某商品的某数量
     *
     * @param userId 用户
     * @param pid    产品id
     * @param skuId  skuid
     * @param num    数量
     */
    @Override
    public void rmProductByNum(Long userId, Long pid, Long skuId, Integer num) {
        SpringBeanFactory.getBean(Cart.class, userId).rmProductByNum(pid, skuId, num);
    }
}
