var commentBx =  document.querySelectorAll("#commentBox");
var show = document.querySelectorAll("#showComments");

for (var i = 0; i < commentBx.length; i++) {
    commentBx[i].style.display="none";
}


var showComments = function(index, object) {

        if(commentBx[index].style.display === "none"){
            object.innerHTML = "Hide Comments";
            commentBx[index].style.display = "block"; 
        }else{
        commentBx[index].style.display = "none";
        object.innerHTML = "Show Comments";
        }
    
}; 