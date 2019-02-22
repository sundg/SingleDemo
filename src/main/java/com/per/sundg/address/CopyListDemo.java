package com.per.sundg.address;

import com.per.sundg.entity.Dic;

import java.util.ArrayList;
import java.util.List;


public class CopyListDemo {
	public static void main(String[] args) {
		List<Dic> list=new ArrayList<Dic>();
		Dic dic=new Dic();
		dic.setDicKey("a1");
		dic.setDicValue(1.1);
		Dic dic2=new Dic();
		dic2.setDicKey("a1");
		dic2.setDicValue(2.1);
		Dic dic3=new Dic();
		dic3.setDicKey("a1");
		dic3.setDicValue(3.1);
		list.add(dic);
		list.add(dic2);
		list.add(dic3);
		
		List<Dic> copy=new ArrayList<Dic>();
		System.out.println(list.get(1).getDicValue());
		list.get(1).setDicValue(3);
		System.out.println(list.get(1).getDicValue());
		list.get(1).setDicValue(4.4);
		copy.add(list.get(1));
		System.out.println(copy.get(0).getDicValue());
	}
}
