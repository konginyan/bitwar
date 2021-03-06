package Node;

import Expection.CompileException;
import Compiler.TokenList;
import Expection.RunningException;

import java.util.Map;

@SuppressWarnings("all")
public class StmtListTree implements Tree{
    private StmtTree firstStmt;
    private StmtTree cursor;

    public StmtListTree(){
        firstStmt = null;
    }

    public void addStmt(StmtTree tree){
        if(firstStmt == null) firstStmt = tree;
        else cursor.setNextStmt(tree);
        cursor = tree;
    }

    @Override
    public void grow(TokenList tokens) throws CompileException {
        while (true){
            StmtTree tree = new StmtTree();
            tree.grow(tokens);
            if(tree.getCondition().equals("null")) break;
            else addStmt(tree);
        }
    }

    @Override
    public Integer run(Map<String, Integer> localVal) throws RunningException {
        return firstStmt.run(localVal);
    }

    @Override
    public void print(int deep) {
        firstStmt.print(deep);
    }
}
