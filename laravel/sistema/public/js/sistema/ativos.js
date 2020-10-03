
$(function(){
    
    $('.bt-editar').click(function(){
        try{
            let strData = $(this).attr('data-dados')
            let arrData = strData.split(',')
            
            $('#id').val(arrData[0])
            $('#cpNomeAtivo').val(arrData[1])
            $('#cpValor').val(arrData[2])
            $('#cpTipo').val(arrData[3]).trigger('change')
            
            $('#cpNomeAtivo').focus()

        }catch(e){
            console.error(e)
        }
    })

})