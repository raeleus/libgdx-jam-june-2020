package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

public interface Move {
    boolean canPerform(PerformerEntity performer);
    void execute(PerformerEntity performer);
    void update(PerformerEntity performer, float delta);
    void continueExecution(PerformerEntity performer);
}