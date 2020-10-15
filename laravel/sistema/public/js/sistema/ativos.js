
$(function(){
    
    $('#cpNomeAtivo').keyup(function(){
        $('#cpNomeAtivo').val( $('#cpNomeAtivo').val().toUpperCase() )
    })

    $('.bt-editar').click(function(){
        try{
            let strData = $(this).attr('data-dados')
            let arrData = strData.split(',')
            
            $('#id').val(arrData[0])
            $('#cpNomeAtivo').val(arrData[1])
            $('#cpValor').val(arrData[2])
            $('#cpTipo').val(arrData[3]).trigger('change')
            $('#cpTaxaAdministracao').val(arrData[4])
            $('#cpTaxaCustodia').val(arrData[5])
            $('#cpTaxaPerformace').val(arrData[6])
            
            $('#cpNomeAtivo').focus()

        }catch(e){
            console.error(e)
        }
    })

})