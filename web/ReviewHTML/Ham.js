/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function kiemTra(a, b, c){
    while(!(a>=-100 && a<= 100) || !(b>=-100 && b<=100) || !(c>=-100 && c<=100)){
        alert("Sai số");
    }
}

function timMax(a, b, c){
    var max = a;
    if(max < b) max = b;
    if(max < c) max = c;
    return max;
}
function timMin(a, b, c){
    var min = a;
    if(min > b) min = b;
    if(min  > c) min = c;
    return min;
}

function luaChon(option, a, b, c){
    if(option.value=='max'){
        return timMax(a, b, c);
    }
    else{
        return timMin(a, b, c);
    }
}


