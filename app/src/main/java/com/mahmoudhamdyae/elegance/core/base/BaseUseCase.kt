package com.mahmoudhamdyae.elegance.core.base

import android.util.Log

private const val TAG = "BaseUseCase"

abstract class BaseUseCase<in Params, out Result> {
    abstract suspend fun execute(params: Params): Result

    suspend operator fun invoke(params: Params): Result {
        // Common logic like logging, error handling, etc.
        return try {
            execute(params)
        } catch (e: Exception) {
            Log.e(TAG, "Exception: ${e.message}", )
            throw e
        }
    }
}