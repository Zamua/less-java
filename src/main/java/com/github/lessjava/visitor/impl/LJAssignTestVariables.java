package com.github.lessjava.visitor.impl;

import java.util.HashSet;

import com.github.lessjava.types.ast.ASTProgram;
import com.github.lessjava.types.ast.ASTTest;
import com.github.lessjava.visitor.LJDefaultASTVisitor;

public class LJAssignTestVariables extends LJDefaultASTVisitor {
    private static HashSet<String> emittedVariables = new HashSet<>();

    public ASTProgram program;

    public boolean inTest;

    @Override
    public void preVisit(ASTProgram node) {
        this.program = node;
    }

    @Override
    public void preVisit(ASTTest node) {
        super.preVisit(node);

        this.inTest = true;
    }

    @Override
    public void postVisit(ASTTest node) {
        super.postVisit(node);

        this.inTest = false;
    }

    //@Override
    //public void preVisit(ASTVariable node) {
        //super.preVisit(node);

        //if (!inTest || emittedVariables.contains(node.name)) {
            //return;
        //}

        //ASTVariable testVar = new ASTVariable(node.toString());
        //testVar.type = node.type;
        //testVar.isCollection = node.isCollection;
        //testVar.setDepth(node.getDepth());
        //testVar.setParent(node.getParent());
        //testVar.setParentScope(node.getParentScope());

        //ASTVariable testVal = new ASTVariable(node.toString().substring(6));
        //testVar.type = node.type;
        //testVar.isCollection = node.isCollection;
        //testVar.setDepth(node.getDepth());
        //testVar.setParent(program);
        //testVar.setParentScope(program);

        //this.program.statements.add(new ASTVoidAssignment(BinOp.ASGN, testVar, testVal));

        //emittedVariables.add(node.name);
    //}
}
