//by renhuimin
$(document).ready(function() {
    var index = parent.layer.getFrameIndex(window.name);
    $(".pages-table li.page-type").click(function() {
        var datatype = $(this).data("type");
        if (!$(this).hasClass("current-page-type")) {
            $(this).siblings().removeClass("current-page-type");
            $(this).addClass("current-page-type");
            $(this).parents(".pages-table").find("table").removeClass("table-show");
            $(this).parents(".pages-table").find("table[data-type=" + datatype + "]").addClass("table-show");
        }
    });
    $(".new-page").click(function() {
        layer.open({
            type: 2,
            title: "新建页面",
            skin: 'layui-layer-rim',
            area: ['700px', '500px'],
            content: "/seller/designManage/page-add.htm"
        });
    });
    $("body").on("click", ".J_TSubmit", function() {
        var title = $('.input-box').val().trim();
        if (title == '') {
            parent.layer.msg('页面名称不能为空，请填写');
            return;
        }
        var params = $('#submit-new-page').serialize();
        $.ajax({
            url: '/seller/designManage/page-add.htm',
            type: 'get',
            data: params,
            success: function() {
                parent.location.reload();
            }
        });
    });
    $("body").on("click", ".page-del", function() {
        var dataid = $(this).attr("data-id");
        var $this = $(this);
        //console.log(dataid);
        $.ajax({
            url: '/seller/designManage/page-remove.json',
            type: 'post',
            data: {
                "id": dataid
            },
            dataType: 'json',
            success: function(d) {
                console.log(d.status);
                if (d.status == "0") {
                    $this.parents("tr").remove();
                }
            }
        });
    })
    $('.btn-cancel').click(function() {
        parent.layer.close(index);
    });
});