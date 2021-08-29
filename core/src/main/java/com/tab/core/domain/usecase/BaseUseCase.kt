package com.tab.core.domain.usecase

import com.tab.core.model.Param

interface BaseUseCase<Input, Output> {
    operator fun invoke(param: Param<Input>): Result<Output>
}