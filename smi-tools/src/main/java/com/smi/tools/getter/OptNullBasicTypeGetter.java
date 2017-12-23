package com.smi.tools.getter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 基本类型的getter接口抽象实现<br>
 * 提供一个统一的接口定义返回不同类型的值（基本类型）<br>
 * 在不提供默认值的情况下， 如果值不存在或获取错误，返回null<br>
 * 用户只需实现{@code com.xiaoleilu.hutool.getter.OptBasicTypeGetter}接口即可
 */
public abstract class OptNullBasicTypeGetter<K> implements BasicTypeGetter<K>, OptBasicTypeGetter<K>{
	
	public Object getObj(K key) {
		return getObj(key, null);
	}
	
	/**
	 * 获取字符串型属性值<br>
	 * 无值或获取错误返回null
	 * 
	 * @param key 属性名
	 * @return 属性值
	 */
	public String getStr(K key){
		return this.getStr(key, null);
	}
	
	/**
	 * 获取int型属性值<br>
	 * 无值或获取错误返回null
	 * 
	 * @param key 属性名
	 * @return 属性值
	 */
	public Integer getInt(K key) {
		return this.getInt(key, null);
	}
	
	/**
	 * 获取short型属性值<br>
	 * 无值或获取错误返回null
	 * 
	 * @param key 属性名
	 * @return 属性值
	 */
	public Short getShort(K key){
		return this.getShort(key, null);
	}
	
	/**
	 * 获取boolean型属性值<br>
	 * 无值或获取错误返回null
	 * 
	 * @param key 属性名
	 * @return 属性值
	 */
	public Boolean getBool(K key){
		return this.getBool(key, null);
	}
	
	/**
	 * 获取long型属性值<br>
	 * 无值或获取错误返回null
	 * 
	 * @param key 属性名
	 * @return 属性值
	 */
	public Long getLong(K key){
		return this.getLong(key, null);
	}
	
	/**
	 * 获取char型属性值<br>
	 * 无值或获取错误返回null
	 * 
	 * @param key 属性名
	 * @return 属性值
	 */
	public Character getChar(K key){
		return this.getChar(key, null);
	}
	
	/**
	 * 获取float型属性值<br>
	 * 无值或获取错误返回null
	 * 
	 * @param key 属性名
	 * @return 属性值
	 */
	public Float getFloat(K key){
		return this.getFloat(key, null);
	}
	
	/**
	 * 获取double型属性值<br>
	 * 无值或获取错误返回null
	 * 
	 * @param key 属性名
	 * @return 属性值
	 */
	public Double getDouble(K key){
		return this.getDouble(key, null);
	}
	
	/**
	 * 获取byte型属性值<br>
	 * 无值或获取错误返回null
	 * 
	 * @param key 属性名
	 * @return 属性值
	 */
	public Byte getByte(K key){
		return this.getByte(key, null);
	}
	
	/**
	 * 获取BigDecimal型属性值<br>
	 * 无值或获取错误返回null
	 * 
	 * @param key 属性名
	 * @return 属性值
	 */
	public BigDecimal getBigDecimal(K key){
		return this.getBigDecimal(key, null);
	}
	
	/**
	 * 获取BigInteger型属性值<br>
	 * 无值或获取错误返回null
	 * 
	 * @param key 属性名
	 * @return 属性值
	 */
	public BigInteger getBigInteger(K key){
		return this.getBigInteger(key, null);
	}
}
