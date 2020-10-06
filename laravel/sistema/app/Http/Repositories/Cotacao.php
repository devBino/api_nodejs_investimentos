<?php
namespace App\Http\Repositories;

use App\Http\Models\CotacaoData;
use App\Http\Repositories\FiltroArray;

class Cotacao{

    public static function listar($ativos){
        
        $return = [];

        for( $i=0; $i<count($ativos); $i++ ){
            
            $dadosCotacao    = CotacaoData::consultarCotacao($ativos[$i]->nmAtivo);
            $arrValorCotacao = FiltroArray::filtrarResultadoChaves($dadosCotacao, ['response','results',strtoupper($ativos[$i]->nmAtivo)] );

            $achouPreco = ( !is_null($arrValorCotacao['array']) && count($arrValorCotacao['array']) && isset($arrValorCotacao['array']['price']) );

            $return[] = [
                'ativo'=>$ativos[$i]->nmAtivo,
                'cotacao'=> $achouPreco ? $arrValorCotacao['array']['price'] : 0.00,
                'status'=> $achouPreco ? 'Encontrado' : 'Não Encontrado'
            ];

        }

        return $return;

    }

    
    public static function pesquisar($ativos){
        
        $return = [];

        for( $i=0; $i<count($ativos); $i++ ){
            
            $dadosCotacao    = CotacaoData::consultarCotacao($ativos[$i]);
            $arrValorCotacao = FiltroArray::filtrarResultadoChaves($dadosCotacao, ['response','results',strtoupper($ativos[$i])] );

            $achouPreco = ( !is_null($arrValorCotacao['array']) && count($arrValorCotacao['array']) && isset($arrValorCotacao['array']['price']) );

            $return[] = [
                'ativo'=>$ativos[$i],
                'cotacao'=> $achouPreco ? $arrValorCotacao['array']['price'] : 0.00,
                'status'=> $achouPreco ? 'Encontrado' : 'Não Encontrado'
            ];

        }

        return $return;

    }


}