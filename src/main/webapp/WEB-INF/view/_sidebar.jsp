<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MENU</li>

            <li ${param.page == "test" ? "class=active" : ""}>
                <a href="${pageContext.request.contextPath}/test"><i class="fa fa-shopping-cart"></i> <span>Test</span></a>
            </li>
            <li ${param.page == "category" ? "class=active" : ""}>
                <a href="${pageContext.request.contextPath}/category"><i class="fa fa-tags"></i> <span>Category</span></a>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>