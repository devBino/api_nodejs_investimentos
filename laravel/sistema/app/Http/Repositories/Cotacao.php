<?php
namespace App\Http\Repositories;

use App\Http\Models\CotacaoData;
use App\Http\Repositories\FiltroArray;

class Cotacao{

    public static function listar($ativos){
        
        $return = [];

        for( $i=0; $i<count($ativos); $i++ ){
            $return[] = self::getCotacao($ativos[$i]->nmAtivo);
        }

        return $return;

    }

    
    public static function pesquisar($ativos){
        
        $return = [];

        for( $i=0; $i<count($ativos); $i++ ){
            $return[] = self::getCotacao($ativos[$i]);
        }

        return $return;

    }

    public static function getCotacao($ativo){
        $dadosCotacao       = CotacaoData::consultarCotacao($ativo);
        $arrValorCotacao    = FiltroArray::filtrarResultadoChaves($dadosCotacao, ['response','results',strtoupper($ativo)]);
        
        $achouPreco = ( !is_null($arrValorCotacao['array']) && count($arrValorCotacao['array']) && isset($arrValorCotacao['array']['price']) );

        return [
            'ativo'=>$ativo,
            'cotacao'=> $achouPreco ? $arrValorCotacao['array']['price'] : 0.00,
            'status'=> $achouPreco ? 'Encontrado' : 'Não Encontrado'
        ];
    }


}