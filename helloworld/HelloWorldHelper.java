package helloworld;


/**
* helloworld/HelloWorldHelper.java .
* 由 IDL-to-Java 编译器（可移植），版本 "3.2" 生成
* 来自 helloworld.idl
* 2015年3月31日 星期二 下午05时50分30秒 CST
*/

abstract public class HelloWorldHelper
{
  private static String  _id = "IDL:helloworld/HelloWorld:1.0";

  public static void insert (org.omg.CORBA.Any a, helloworld.HelloWorld that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static helloworld.HelloWorld extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (helloworld.HelloWorldHelper.id (), "HelloWorld");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static helloworld.HelloWorld read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HelloWorldStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, helloworld.HelloWorld value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static helloworld.HelloWorld narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof helloworld.HelloWorld)
      return (helloworld.HelloWorld)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      helloworld._HelloWorldStub stub = new helloworld._HelloWorldStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static helloworld.HelloWorld unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof helloworld.HelloWorld)
      return (helloworld.HelloWorld)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      helloworld._HelloWorldStub stub = new helloworld._HelloWorldStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
