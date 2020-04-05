function save(){
    let title = document.getElementById('note_title').value.toString();
    let content = document.getElementById('editor').value.toString();

    if(content===''){
        swal("失败!", response.message, {
            icon : "error",
            buttons: {
                confirm: {
                    className : 'btn btn-danger'
                }
            }
        });
    }

    if(title===''){
        if(content.length >= 6)
            title = content.substring(0, 6);
        else
            title = content;
    }



    //获取cookie字符串
    var strCookie=document.cookie;
    //将多cookie切割为多个名/值对
    var arrCookie=strCookie.split("; ");
    var userId;
    //遍历cookie数组，处理每个cookie对
    for(var i=0;i<arrCookie.length;i++){
        var arr=arrCookie[i].split("=");
        //找到名称为userId的cookie，并返回它的值
        if("id"==arr[0]){
            userId=arr[1];
            break;
        }
    }

    $.ajax({
        url: "/note/addNote",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            title: title,
            content: content,
            category: "学习",  //category,
            uid: 1,
            nbid: 1 //nbid
        }),
        success: function f(response){
            console.log(response);
            if(response.result===true){
                // setCookie("id", response.data, 1000);
                swal("保存成功!", response.message, {
                    icon : "success",
                    buttons: {
                        confirm: {
                            text: "确定",
                            className : 'btn btn-success'
                        },
                    },
                }).then(function(){
                    // window.location.href = "index.html";
                });
            }else{
                swal("失败!", response.message, {
                    icon : "error",
                    buttons: {
                        confirm: {
                            className : 'btn btn-danger'
                        }
                    },
                });
            }
        }
    })
}