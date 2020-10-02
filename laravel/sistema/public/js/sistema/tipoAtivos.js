
$(function(){
    
    $('.bt-editar').click(function(){
        try{
            let strData = $(this).attr('data-dados')
            let arrData = strData.split(',')
    
            $('#id').val(arrData[0])
            $('#cpNomeTipo').val(arrData[1])
            $('#cpNomeTipo').focus()

        }catch(e){
            console.error(e)
        }
    })

})