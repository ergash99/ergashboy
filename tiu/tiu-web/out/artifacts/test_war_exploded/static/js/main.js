var currentPage = 0;

var url_base = 'base';

var div_base = 'base';

var currentElemId = -1;


$(document).ready(function(){
    $("[data-toggle=tooltip]").tooltip();


    $("#fileupload-remove").on('click', function () {
        $(".fileupload-new .thumbnail").html('');
    });
    $("#begin-date").datepicker();
    $("#end-date").datepicker();



});

function  ajaxLoader(url){
    $.ajax({
        url: url,
        cache: false,
        type:'GET',
        success: function (html) {
            $("#"+div_base).html(html);
        }

    });
}
function save(){
    console.log("save");
    var paramStr = $('#form-users').serialize();
    ajaxLoader(url_base +'-save.htm?' + paramStr)

}

function edit(id){
    ajaxLoader(url_base + '-edit.htm?id='+id);
}
function filterSearchPagination(pageId) {
    window.location.href = url_base + '.htm?page='+pageId;
}

function confirmRemove(id) {

    console.log(url_base)
    bootbox.confirm({
        title: "O'chirishni ",
        message: "O'chishni tasdiqlang",
        buttons: {
            confirm: {
                label: "Tasdiqlash",
                className: 'btn btn-danger'
            },
            cancel: {
                label: "Cancel",
                className: 'btn btn-default'
            }
        },
        callback: function (result) {
            if (result) {
                window.location.href = url_base + '-delete.htm?id='+id;

            }
        }
    });
}



