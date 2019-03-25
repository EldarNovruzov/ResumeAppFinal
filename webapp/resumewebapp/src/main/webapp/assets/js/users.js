// function writeWhatIamTyping() {
//     var inputtext=  document.getElementById("whatIamTyping");
//     var text= document.getElementById("typing");
//     var textStr= inputtext.value;
//
//     text.innerHTML=textStr;
// }
//
// function changeColor() {
//     var btnsearch= document.getElementById("btnsearch");
//     btnsearch.style="background-color: red";
// }
//
// function showHide() {
//     var btnsearch= document.getElementById("btnsearch");
//
//     if (btnsearch.visible){
//         btnsearch.visible=false;
//         btnsearch.style="display: none";
//     }else{
//         btnsearch.visible=true;
//         btnsearch.style="display: block";
//     }
//
// }

function setIdForDelete(id) {
    var element=document.getElementById("idForDelete");
    element.value=id;
}