
$(document).ready(function(){

    $("#getResult").click(function(){
        var style = $("#style option:selected").val();
        var health = $("#health option:selected").val();
        var ambitions = $("#ambitions option:selected").val();
        var interests=0;
        if($("#psychology").prop("checked")) interests=1;
        if($("#education_hobbie").prop("checked")) interests=2;
        var education = $("#education option:selected").val();
        var gender = $("#gender option:selected").val();
        var age = $("#age").val();
        var foreign = $("#foreign option:selected").val();
        var iq = $("#iq").val();
        var god = $("#god option:selected").val();
        var politics =  $("#politics option:selected").val();
        var request = "/profession?style="+style+"&health="+health+"&ambitions="+ambitions+"&interests="+interests+"&education="+education+ "&gender="+gender+"&age="+age+"&foreign="+foreign+"&iq="+iq+"&god="+god+"&politics="+politics;
        $.get(request+"&isText=true", function(data) {
            $(".result").html(data);
        });
    })
});


