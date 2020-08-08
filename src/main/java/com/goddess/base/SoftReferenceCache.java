package com.goddess.base;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

/**
 * 软引用实现高速缓存
 *
 * @author qinshengke
 * @since 2020/7/31 16:47
 **/
public class SoftReferenceCache {

	/**
	 * 一个Cache实例
	 */
	private static SoftReferenceCache cache;

	/**
	 * 用于 cache 内容的存储
	 */
	private final Hashtable<String, EmployeeRef> employeeRefs;
	private final ReferenceQueue<Employee> referenceQueue;// 垃圾Reference的队列

	/**
	 * 继承SoftReference，使得每一个实例都具有可识别的标识。并且该标识与其在HashMap内的key相同。
	 */
	private static class EmployeeRef extends SoftReference<Employee> {
		private String _key = "";

		public EmployeeRef(Employee object, ReferenceQueue<Employee> q) {
			super(object, q);
			_key = object.getId();
		}
	}

	/**
	 * 构建一个缓存器实例
	 */
	private SoftReferenceCache() {
		employeeRefs = new Hashtable<>();
		referenceQueue = new ReferenceQueue<Employee>();
	}

	/**
	 * 取得缓存器实例
	 */
	public static SoftReferenceCache getInstance() {
		if (cache == null) {
			cache = new SoftReferenceCache();
		}
		return cache;
	}

	/**
	 * 以软引用的方式对一个Employee对象的实例进行引用并保存该引用
	 */
	private void cacheEmployee(Employee em) {
		cleanCache();// 清除垃圾引用
		EmployeeRef ref = new EmployeeRef(em, referenceQueue);
		employeeRefs.put(em.getId(), ref);
	}

	/**
	 * 依据所指定的ID号，重新获取相应Employee对象的实例
	 */
	public Employee getEmployee(String ID) {
		Employee em = null;
		// 缓存中是否有该Employee实例的软引用，如果有，从软引用中取得。
		if (employeeRefs.containsKey(ID)) {
			EmployeeRef ref = (EmployeeRef) employeeRefs.get(ID);
			em = (Employee) ref.get();
		}
		// 如果没有软引用，或者从软引用中得到的实例是null，重新构建一个实例，
		// 并保存对这个新建实例的软引用
		if (em == null) {
			em = new Employee(ID);
			System.out.println("Retrieve From EmployeeInfoCenter. ID=" + ID);
			this.cacheEmployee(em);
		}
		return em;
	}

	/**
	 * 清除那些所软引用的Employee对象已经被回收的EmployeeRef对象
	 */
	private void cleanCache() {
		EmployeeRef ref = null;
		while ((ref = (EmployeeRef) referenceQueue.poll()) != null) {
			employeeRefs.remove(ref._key);
		}
	}

	/**
	 * 清除Cache内的全部内容
	 */
	public void clearCache() {
		cleanCache();
		employeeRefs.clear();
		System.gc();
		System.runFinalization();
	}
}