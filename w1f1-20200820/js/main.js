

function doShowHide(id) {

    var display = document.getElementById(id);
    if(display.style.display=='none'){
        display.style.display = 'block';
    }
    else {
        display.style.display = 'none';
    }

}

function doGobyAjax(aa){
    $.ajax({
      type : "GET",
      url : aa,
      dataType : "text",
      error : function() {
        alert('통신실패!!');
      },
      success : function(data) {
        $('#contents').html(data);
      }

    });
}


function test(aa){

    alert(aa);
}

  