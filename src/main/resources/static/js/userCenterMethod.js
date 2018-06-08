$(document).ready(function () {
    console.log("asds");

    //上传头像
    $("#t_photo").change(function () {
        var theHeadimageFile = $("#t_photo").val();
        var s = theHeadimageFile.lastIndexOf(".");
        theHeadimageFile = theHeadimageFile.substring(s+1,theHeadimageFile.length);
        console.log("文件类型："+theHeadimageFile);
        if (theHeadimageFile == "jpg" || theHeadimageFile == "jpeg" || theHeadimageFile == "png" || theHeadimageFile == "bmp" || theHeadimageFile == "gif"){
            $.ajaxFileUpload({
                url:"/uploadImage",
                type:"post",
                data:{},
                dataType:"text",
                secureuri:false,
                fileElementId:['t_photo'],
                success:function (data) {
                    if (data == "no"){
                        alert("文件格式不正确")
                    } else{
                        //头像更改
                        console.log("上传成功")
                    }
                },error:function (data) {
                    console.log("头像上传功能出错")
                }
            })
        }else{
            alert("文件格式错误！");
        }
    });

})