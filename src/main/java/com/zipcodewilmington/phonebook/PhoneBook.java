package com.zipcodewilmington.phonebook;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    Map<String,List<String>> mapper = new HashMap<>();


    public PhoneBook(Map<String, List<String>> map) {
     mapper = map;
    }
    public PhoneBook() {

    }

    public void add(String name, String phoneNumber) {
        mapper.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        mapper.put(name, Arrays.asList(phoneNumbers));

    }

    public void remove(String name) {
        mapper.remove(name);
    }

    public Boolean hasEntry(String name) {

        return mapper.containsKey(name);
    }

    public List<String> lookup(String name) {

        return mapper.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String namers = "";
        for(String name : mapper.keySet())
            if(mapper.get(name).contains(phoneNumber) ) {
                namers += name;
            }
        return namers;
    }

    public List<String> getAllContactNames() {
        List<String> mapperList = new ArrayList();
        mapperList.addAll(mapper.keySet());
        Collections.sort(mapperList);

        return mapperList;
    }

    public Map<String, List<String>> getMap() {

        return mapper;
    }
}
