/*-
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 *
 */

package org.nd4j.linalg.api.ops.impl.accum;

import org.nd4j.autodiff.samediff.SDVariable;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.BaseAccumulation;

import java.util.Collections;
import java.util.List;

/**
 * Boolean AND pairwise transform
 *
 * @author raver119@gmail.com
 */
public class Any extends BaseAccumulation {
    public Any(SameDiff sameDiff, SDVariable i_v, int[] dimensions) {
        super(sameDiff, i_v, dimensions);
    }

    public Any() {}

    public Any(INDArray x) {
        super(x);
    }

    @Override
    public Type getOpType() {
        return Type.REDUCE;
    }


    @Override
    public int opNum() {
        return 20;
    }

    @Override
    public String opName() {
        return "any";
    }

    @Override
    public List<SDVariable> doDiff(List<SDVariable> f1) {
        return Collections.singletonList(f().zerosLike(arg()));
    }

    @Override
    public String onnxName() {
        return "Any";
    }

    @Override
    public String tensorflowName() {
        return "Any";
    }
}
