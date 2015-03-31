package helloworld;

/**
* helloworld/HelloWorldHolder.java .
* 由 IDL-to-Java 编译器（可移植），版本 "3.2" 生成
* 来自 helloworld.idl
* 2015年3月31日 星期二 下午05时50分30秒 CST
*/

public final class HelloWorldHolder implements org.omg.CORBA.portable.Streamable
{
  public helloworld.HelloWorld value = null;

  public HelloWorldHolder ()
  {
  }

  public HelloWorldHolder (helloworld.HelloWorld initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = helloworld.HelloWorldHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    helloworld.HelloWorldHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return helloworld.HelloWorldHelper.type ();
  }

}
