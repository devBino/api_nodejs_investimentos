<?php

use Illuminate\Support\Facades\Route;

Route::get('/tipos-ativos','TipoAtivo@index');
Route::post('/tipos-ativos-salvar','TipoAtivo@salvar');
Route::get('/tipos-ativos-deletar/{id}','TipoAtivo@deletar');
Route::post('/tipos-ativos-alterar','TipoAtivo@alterar');