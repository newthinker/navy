package cn.com.hd.service;

import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public abstract interface IService
{
  public abstract Response service(Request paramRequest)
    throws Exception;
}

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.service.IService
 * JD-Core Version:    0.6.0
 */