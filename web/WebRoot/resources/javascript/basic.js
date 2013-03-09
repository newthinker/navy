function BtZebraStrips(id,tag) {
    var ListId = document.getElementById(id);
    if(ListId){
    var tags  = ListId.getElementsByTagName(tag);
    for(var i=0;i<tags.length;i++) {
    tags[i].className   += " barry"+i%2;
    tags[i].onmouseover = function(){this.className += " hover"}
    tags[i].onmouseout  = function(){this.className = this.className.replace(" hover","")}}}
}