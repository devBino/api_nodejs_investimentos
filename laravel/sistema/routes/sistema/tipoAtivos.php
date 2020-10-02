<?php

use Illuminate\Support\Facades\Route;

Route::get('/tipo-ativos','TipoAtivo@index');
Route::post('/tipo-ativos-salvar','TipoAtivo@salvar');
Route::get('/tipo-ativos-deletar/{id}','TipoAtivo@deletar');