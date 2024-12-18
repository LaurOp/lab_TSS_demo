package com.tss;

public class Main {
    public static void main(String[] args) {
        var demoObject = new Demo();
        System.out.println(demoObject.method("abcdef"));
        System.out.println(demoObject.method("Abcdef"));
        System.out.println(demoObject.method("ABCDEF"));
        System.out.println(demoObject.method("abcdef1"));
        System.out.println(demoObject.method("abcdef@"));
        System.out.println(demoObject.method("abc"));
        System.out.println(demoObject.method("abcdefabcdefabcdefabcdef"));
    }
}