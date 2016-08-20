package org.orienteer.bpm.camunda.handler;

import com.orientechnologies.orient.core.metadata.schema.OType;
import org.camunda.bpm.engine.batch.BatchQuery;
import org.camunda.bpm.engine.impl.batch.BatchEntity;
import org.orienteer.bpm.camunda.OPersistenceSession;
import org.orienteer.core.util.OSchemaHelper;

import java.util.List;

/**
 * Created by KMukhov on 12.08.2016.
 */
public class BatchEntityHandler extends AbstractEntityHandler<BatchEntity> {

    public static final String OCLASS_NAME = "BPMBatch";

    public BatchEntityHandler() {
        super(OCLASS_NAME);
    }

    @Override
    public void applySchema(OSchemaHelper helper) {
        super.applySchema(helper);

        helper.oProperty("type", OType.STRING, 10)
                .oProperty("totalJobs", OType.INTEGER, 20)
                .oProperty("jobsCreated", OType.INTEGER, 30)
                .oProperty("batchJobsPerSeed", OType.INTEGER, 40)
                .oProperty("invocationsPerBatchJob", OType.INTEGER, 50)
                .oProperty("seedJobDefinitionId", OType.STRING, 60)
                .oProperty("monitorJobDefinitionId", OType.STRING, 70)
                .oProperty("batchJobDefinitionId", OType.STRING, 80)
                .oProperty("configuration", OType.STRING, 90)
                .oProperty("tenantId", OType.STRING, 100)
                .oProperty("suspensionState", OType.INTEGER, 110);
    }

    @Statement
    public List<BatchEntity> selectBatchesByQueryCriteria(OPersistenceSession session, BatchQuery query) {
        return query(session, query);
    }
}