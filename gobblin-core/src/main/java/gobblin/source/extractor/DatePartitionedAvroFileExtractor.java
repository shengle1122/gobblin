/*
 * Copyright (C) 2014-2016 LinkedIn Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.
 */

package gobblin.source.extractor;

import gobblin.configuration.WorkUnitState;
import gobblin.source.extractor.hadoop.AvroFileExtractor;


/**
 * Extension of {@link AvroFileExtractor} where the {@link #getHighWatermark()} method returns the result of the
 * specified WorkUnit's {@link gobblin.source.workunit.WorkUnit#getHighWaterMark()} method.
 */
public class DatePartitionedAvroFileExtractor extends AvroFileExtractor {

  public DatePartitionedAvroFileExtractor(WorkUnitState workUnitState) {
    super(workUnitState);
  }

  /**
   * Returns the HWM of the workUnit
   * {@inheritDoc}
   * @see gobblin.source.extractor.filebased.FileBasedExtractor#getHighWatermark()
   */
  @Override
  public long getHighWatermark() {
    return this.workUnit.getHighWaterMark();
  }
}
