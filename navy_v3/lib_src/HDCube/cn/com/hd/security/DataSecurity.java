package cn.com.hd.security;

public abstract interface DataSecurity
{
  public abstract String decrypt(String paramString);

  public abstract String encrypt(String paramString);
}

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.security.DataSecurity
 * JD-Core Version:    0.6.0
 */