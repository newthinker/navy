setInterval("linkweb.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
/* 
var week; 
if(new Date().getDay()==0)          week="周日"
if(new Date().getDay()==1)          week="周一"
if(new Date().getDay()==2)          week="周二" 
if(new Date().getDay()==3)          week="周三"
if(new Date().getDay()==4)          week="周四"
if(new Date().getDay()==5)          week="周五"
if(new Date().getDay()==6)          week="周六"
document.write((new Date().getMonth()+1)+"月"+new Date().getDate()+"日 "+week);
*/