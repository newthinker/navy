
/* ==================== ScriptHelper ��ʼ ==================== */
/* scriptHelper �ű���������.
������: ziqiu.zhang 2008.3.5
��Ӻ���:
getScroll():�õ��������ľ���-����XHTML
getClient():�õ��������ǰ��ʾ����Ĵ�С-����XHTML
showDivCommon():��ʾͼ��.
ʹ�þ���:
<div id="testDiv" style="display:none; position:absolute; border:1px #000000;">���ǲ���ͼ�����ǲ���ͼ��</div>
<div style="width:400px; text-align:center;"><div><a href="#" onclick="ScriptHelper.showDivCommon(this,'testDiv', 20, 70)">�¼�Դ</a></div></div>
*/
function scriptHelper() 
{
}

// �õ��������ľ��� scrollTop �� scrollLeft
/* �÷������:
var myScroll = getScroll();
alert("myScroll.scrollTop:" + myScroll.scrollTop);
alert("myScroll.scrollLeft:" + myScroll.scrollLeft);
*/
scriptHelper.prototype.getScroll = function() 
{
    var scrollTop = 0, scrollLeft = 0;
    scrollTop = (document.body.scrollTop > document.documentElement.scrollTop) ? document.body.scrollTop : document.documentElement.scrollTop;
    if (isNaN(scrollTop) || scrollTop < 0) {
        scrollTop = 0;
    }
    scrollLeft = (document.body.scrollLeft > document.documentElement.scrollLeft) ? document.body.scrollLeft : document.documentElement.scrollLeft;
    if (isNaN(scrollLeft) || scrollLeft < 0) {
        scrollLeft = 0;
    }
    return {scrollTop: scrollTop,scrollLeft: scrollLeft};
}
// �õ��������ǰ��ʾ����Ĵ�С clientHeight �� clientWidth
/* �÷������:
var myScroll = getScroll();
alert("myScroll.sTop:" + myScroll.sTop);
alert("myScroll.sLeft:" + myScroll.sLeft);
*/
scriptHelper.prototype.getClient = function() 
{
    //�ж�ҳ���Ƿ����XHTML��׼
    var isXhtml = true;
    if (document.documentElement == null || document.documentElement.clientHeight <= 0) 
    {
        if (document.body.clientHeight > 0) 
        {
            isXhtml = false;
        }
    }
    this.clientHeight = isXhtml ? document.documentElement.clientHeight : document.body.clientHeight;
    this.clientWidth = isXhtml ? document.documentElement.clientWidth : document.body.clientWidth;
    return {clientHeight: this.clientHeight,clientWidth: this.clientWidth};
}

// ��ʾͼ��,�ٴε���������
/* ����˵��:
sObj : Ҫ����ͼ����¼�Դ
divId : Ҫ��ʾ��ͼ��ID
sObjHeight : �¼�Դ�ĸ߶�,Ĭ��Ϊ20.��Ҫ�ֹ���������Ϊ���������¼�Դ��������Ǹ���HTMLԪ��,��ЩԪ�ظ߶ȵļ����޷��������ͨ��.
moveLeft : �ֹ������ƶ��ľ���.���ƶ���Ϊ0(Ĭ��).
divObjHeight: ������ĸ߶�.����������0�Ĵ˲���, ���¼�Դ�·��ռ䲻��ʱ,���¼�Դ�Ϸ�������.��������˲�����һֱ���¼�Դ�·�����.
�÷������:
<div><a href="#" onclick="ScriptHelper.showDivCommon(this,'testDiv', 20, 20)">�¼�Դ</a></div>
*/
scriptHelper.prototype.showDivCommon = function(sObj, divId, sObjHeight, moveLeft, divObjHeight) 
{
    //ȡ��ð���¼�
    if (typeof (window) != 'undefined' && window != null && window.event != null) 
    {
        window.event.cancelBubble = true;
    } 
    else if (ScriptHelper.showDivCommon.caller.arguments[0] != null) 
    {
        ScriptHelper.showDivCommon.caller.arguments[0].cancelBubble = true;
    }
    //�������.���û�д������������Ĭ��ֵ
    if (moveLeft == null) 
    {
        moveLeft = 0;
    }
    if (sObjHeight == null) 
    {
        sObjHeight = 20;
    }
    if (divObjHeight == null) 
    {
        divObjHeight = 0;
    }
    
    var divObj = document.getElementById(divId); //���ͼ�����
    var sObjOffsetTop = 0; //�¼�Դ�Ĵ�ֱ����
    var sObjOffsetLeft = 0; //�¼�Դ��ˮƽ����
    var myClient = this.getClient();
    var myScroll = this.getScroll();
    var sWidth = sObj.width; //�¼�Դ����Ŀ��
    var sHeight = sObjHeight; //�¼�Դ����ĸ߶�
    var bottomSpace; //����ײ��ľ���
    /* ��ȡ�¼�Դ�ؼ��ĸ߶ȺͿ��.*/
    if (sWidth == null) 
    {
        sWidth = 100; //�޷���ȡ��Ϊ100
    } 
    else 
    {
        sWidth = sWidth + 1; //����1px�ľ���
    }
    
    if (divObj.style.display.toLowerCase() != "none") 
    {
        //����ͼ��
        divObj.style.display = "none";
    } 
    else 
    {
        if (sObj == null) 
        {
            alert("�¼�Դ����Ϊnull");
            return false;
        }
        /* ��ȡ�¼�Դ�����ƫ���� */
        var tempObj = sObj; //���ڼ����¼�Դ�������ʱ����
        while (tempObj && tempObj.tagName.toUpperCase() != "BODY") 
        {
            sObjOffsetTop += tempObj.offsetTop;
            sObjOffsetLeft += tempObj.offsetLeft;
            tempObj = tempObj.offsetParent;
        }
        tempObj = null;

        /* ��ȡ����ײ��ľ��� */
        bottomSpace = parseInt(myClient.clientHeight) - (parseInt(sObjOffsetTop) - parseInt(myScroll.scrollTop)) - parseInt(sHeight);
        /* ����ͼ����ʾλ�� */
        //����¼�Դ�·��ռ䲻�����Ϸ��ؼ��㹻���ɵ�����,�����Ϸ���ʾ.�������·���ʾ
        if (divObjHeight > 0 && bottomSpace < divObjHeight && sObjOffsetTop > divObjHeight) 
        {
            divObj.style.top = (parseInt(sObjOffsetTop) - parseInt(divObjHeight) - 10).toString() + "px";
        } 
        else 
        {
            divObj.style.top = (parseInt(sObjOffsetTop) + parseInt(sHeight)).toString() + "px";
        }
        divObj.style.left = (parseInt(sObjOffsetLeft) - parseInt(moveLeft)).toString() + "px";
        divObj.style.display = "block";
    }
}

// �ر�ͼ��
/* ����˵��:
divId : Ҫ���ص�ͼ��ID
�÷������:
ScriptHelper.closeDivCommon('testDiv');
*/
scriptHelper.prototype.closeDivCommon = function(divId) 
{
    //
    var divObj = document.getElementById(divId); //���ͼ�����
    if (divObj != null) 
    {
        divObj.style.display = "none";
    }
}
//����scriptHelper���һ��ʵ������.ȫ��ʹ��.
var ScriptHelper = new scriptHelper();
/* ==================== ScriptHelper ���� ==================== */
