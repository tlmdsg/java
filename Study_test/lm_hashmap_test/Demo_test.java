package lm_hashmap_test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Demo_test {

	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("name", "tlm");
		hashMap.put("age", "20");

		// 获得字典里的所有键生成set集合
		Set<String> keys_set = hashMap.keySet();
		for (Iterator iterator = keys_set.iterator(); iterator.hasNext();) {
			String str_keys = (String) iterator.next();
			System.out.println(str_keys);
		}
		// 获得字典里的所有键值对生成Set<Entry<String, String>>集合
		Set<Entry<String, String>> entry_set = hashMap.entrySet();
		
//		for (Iterator iterator = entry_set.iterator(); iterator.hasNext();) {
//			Entry<String, String> e = (Entry<String, String>) iterator.next();
//			System.out.println("key:"+e.getKey()+",value:"+e.getValue());
//		}
		
		for (Entry<String, String> e : entry_set) {
			System.out.println("key:"+e.getKey()+",value:"+e.getValue());
		}
		
		System.out.println(hashMap.size());
		entry_set.clear();
		System.out.println(hashMap.size());
		
	}

}
