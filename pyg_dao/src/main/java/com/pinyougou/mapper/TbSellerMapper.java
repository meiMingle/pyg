package com.pinyougou.mapper;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.pojo.TbSellerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSellerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_seller
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    long countByExample(TbSellerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_seller
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    int deleteByExample(TbSellerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_seller
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    int deleteByPrimaryKey(String sellerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_seller
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    int insert(TbSeller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_seller
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    int insertSelective(TbSeller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_seller
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    List<TbSeller> selectByExample(TbSellerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_seller
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    TbSeller selectByPrimaryKey(String sellerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_seller
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    int updateByExampleSelective(@Param("record") TbSeller record, @Param("example") TbSellerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_seller
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    int updateByExample(@Param("record") TbSeller record, @Param("example") TbSellerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_seller
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    int updateByPrimaryKeySelective(TbSeller record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_seller
     *
     * @mbg.generated Fri Dec 21 14:34:18 CST 2018
     */
    int updateByPrimaryKey(TbSeller record);
}