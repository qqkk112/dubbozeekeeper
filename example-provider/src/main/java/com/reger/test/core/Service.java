package com.reger.test.core;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T> {
    void save(List<T> models);//批量持久化
    void deleteById(Integer id);//通过主鍵刪除
    void deleteByIds(String ids);//批量刪除 eg：ids -> “1,2,3,4”
    T findById(Integer id);//通过ID查找
    T findBy(String fieldName, Object value) throws TooManyResultsException; //通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
    List<T> findByIds(String ids);//通过多个ID查找//eg：ids -> “1,2,3,4”
    List<T> findByCondition(Condition condition);//根据条件查找

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     */
    List<T> select(T record);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     */
    T selectByKey(Object key);

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     */
    List<T> selectAll();

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     */
    T selectOne(T record);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     */
    int selectCount(T record);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     */
    int save(T record);

    /**
     * 根据主键更新属性不为null的值
     */
    int update(T entity);

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     */

    int delete(T record);

    /**
     * 批量删除
     */
    @Transactional
    int batchDelete(List<T> list);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     */
    int deleteByKey(Object key);

    /**
     * 这个查询支持通过Example类指定查询列，通过selectProperties方法指定查询列
     */
    List<T> selectByExample(Object example);

    /**
     * 根据Example条件进行查询总数
     */
    int selectCountByExample(Object example);

    /**
     * 根据Example条件更新实体record包含的不是null的属性值
     */
    int updateByExample(@Param("record") T record, @Param("example") Object example);

    /**
     * 根据Example条件删除数据
     */
    int deleteByExample(Object example);

    /**
     * 根据实体属性和RowBounds进行分页查询
     */
    List<T> selectByRowBounds(T record, RowBounds rowBounds);

    /**
     * 根据example条件和RowBounds进行分页查询
     */
    List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);
}
