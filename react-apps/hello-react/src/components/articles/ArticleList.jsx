/** @format */

const ArticleList = ({ articleData }) => {
    return (
        <>
            {articleData.map((article) => (
                <tr key={article.id}>
                    <td>{article.id}</td>
                    <td>{article.subject}</td>
                    <td>{article.membersVO.name}</td>
                    <td>{article.viewCnt}</td>
                    <td>{article.crtDt}</td>
                </tr>
            ))}
        </>
    );
};
export default ArticleList;