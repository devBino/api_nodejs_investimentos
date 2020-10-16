/**
 * @description Jquery elementos
*/
$(function(){

    $('#cpAtivo').change( async function(){
        try{
            let dadosCotacao = await getCotacao()
            
            if(  parseFloat(dadosCotacao.cotacao) > 0.00 ){
                $('#cpValor').val(dadosCotacao.cotacao)
                $('#cpQtde').focus()
            }else{
                $('#cpValor').val('0.00')
                $('#cpValor').focus()
            }
        }catch(e){
            console.error(e)
            $('#cpValor').val('0.00')
            $('#cpValor').focus()
        }
    })

    $('#cpQtde').keyup(function(){
        try{
            let strValor    = $('#cpValor').val()
            let strQtde     = $('#cpQtde').val()
            let numVal      = parseFloat(strValor)
            let numQtde     = parseFloat(strQtde)
            let subTotal    = numVal * numQtde

            if( !isNaN(subTotal) && subTotal !== undefined ){
                $('#cpSubTotal').val(subTotal.toFixed(2))
            }else{
                $('#cpSubTotal').val("0.00")    
            }
        }catch(e){
            console.error(e)
            $('#cpSubTotal').val("0.00")
        }
    })

    $('.bt-editar').click(function(){
        try{
            let strData = $(this).attr('data-dados')
            let arrData = strData.split(',')
            
            $('#id').val(arrData[0])
            $('#cpAtivo').val(arrData[1]).trigger('change')
            $('#cpValor').val(arrData[2])
            $('#cpQtde').val(arrData[3])
            $('#cpSubTotal').val(arrData[4])
            $('#cpData').val(arrData[5].substr(0,10))
            $('#cpTaxaRetorno').val(arrData[6])
            
            $('#cpAtivo').focus()

        }catch(e){
            console.error(e)
        }
    })

})


/**
 * @description Funcções com Promises implementadas
*/
function getCotacao(){
    return new Promise((resolve,reject)=>{
        try{
            $.ajax({
                url:`/getCotacao/${$('#cpAtivo option:selected').text()}`,
                type:'GET',
                dataType:'json',
                success:function(data){
                    resolve(data)
                },
                error(e){
                    reject({data:"0.00"})        
                }
            })           
        }catch(e){
            reject({data:"0.00"})
        }
    })
}