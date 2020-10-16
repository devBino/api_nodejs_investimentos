<?php

use Illuminate\Support\Facades\Route;

Route::get('/cotacao','Cotacao@index');
Route::post('/cotacao','Cotacao@pesquisar');
Route::get('/getCotacao/{ativo}','Cotacao@getCotacao');